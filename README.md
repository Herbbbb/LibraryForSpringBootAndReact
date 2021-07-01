# LibraryForSpringBootAndReact
前后端分离：springboot + react项目
# 借书

- 查找全部书籍，根据名称查找书籍(String key)，key是null时候，默认查找全部数据，有值的时候，我们去查找对应名称的书籍

  - ```java
    /book/fingListByName
    ```

- 借书

  - 书籍数量是否足够
  - 账户余额(积分)是否足够
  - 真正借书操作
    - 新增一条book_borrow记录
    - 书籍数量减1
    - 账户余额对应减少(还书时候，根据具体租借天数*单价，去进行扣款)，基于账户可能存在负债的前提下，我们在借书的时候，会直接声明租借天数。



请输入书名：_____________ 查找

| 书籍1 | 12.0/天 | 租借 |
| ----- | ------- | ---- |
| 书籍2 | 12.0/天 | 租借 |
|       |         |      |
|       |         |      |



```java
 if(0 >= bookId) {
                return new ResultDTO(HttpCode.FAIL.getCode(), "书籍编号不合法，请确认所选书籍是否存在!");
            }
            // 租借起始截止日期(日期前后的非法校验交给前端来做)
            if(startDate.after(endDate)) {
                return new ResultDTO(HttpCode.FAIL.getCode(), "起始日期不能晚于归还日期!");
            }

            // Step 2:获取书籍
            BookDTO bookDTO = bookMapper.findById(bookId);
            // 2.1 书籍存在性判断
            if(null == bookDTO) {
                return new ResultDTO(HttpCode.FAIL.getCode(), "书籍不存在!");
            }
            // 2.2 数量是否足够的校验
            int bookCount = bookDTO.getBookCount();
            if(bookCount <= 0) {
                // TODO 在查找书籍的时候如果返回的书籍数量为0，前端直接禁用租借按钮，同时加一个效果：当前书籍已租借光了~
                return new ResultDTO(HttpCode.FAIL.getCode(), "当前书籍已被租借光了，请看看别的书吧~");
            }
            if(borrowCount > bookCount) {
                return new ResultDTO(HttpCode.FAIL.getCode(), "借阅数量超过书籍存量，当前剩余数量：~" + bookCount);
            }

            // Step 3: 真正的借书操作
            BookBorrowDTO bookBorrowDTO = new BookBorrowDTO();
            bookBorrowDTO.setBookId(bookId);
            bookBorrowDTO.setBookName(bookDTO.getBookName());
            bookBorrowDTO.setCount(borrowCount);
            bookBorrowDTO.setStartDate(startDate);
            bookBorrowDTO.setEndDate(endDate);
            // 也可以从session获取
            bookBorrowDTO.setUserId(userId);
            bookBorrowDTO.setUserName(userName);
            // 设置书籍价格
            BigDecimal bookPrice = bookDTO.getBookPrice();
            long day = (endDate.getTime() - startDate.getTime()) / (24 * 60 * 60 * 1000);
            long totalPrice = bookPrice.intValue() * day;

            bookBorrowDTO.setPrice(new BigDecimal(totalPrice));
            bookBorrowDTO.setTradeFee(new BigDecimal(totalPrice));
            if(vipFlag) {
                bookBorrowDTO.setTradeFee(new BigDecimal(0.0));
            }
            bookBorrowDTO.setCreateDate(new Date());
            bookBorrowDTO.setValidFlag(ValidFlagEnum.ENABLE);
            // 新增
            int result = bookBorrowService.insert(bookBorrowDTO);
            if(result <= 0) {
                // 新增失败
                return new ResultDTO(HttpCode.FAIL.getCode(), "借书失败，您可以尝试重新借书，或联系图书管理员处理");
            }

            // Step 4:减少书籍数量
            bookDTO.setBookCount(bookCount - borrowCount);
            bookDTO.setUpdateDate(new Date());
            bookMapper.update(bookDTO);

            return new ResultDTO(HttpCode.SUCCESS.getCode(), "借书成功");
```



TODO TIPS

- 优化bookMapper.xml的update方法





int-->Integer				0

double->Double		0.0

long->Long

String->String





int a=1,b=2,c=3;		-128---127  常量池

a = b+c



Integer a =new Int

Integer b =1

Integer c=2



a = b+c，true，1+2=3



# 还书

- 书籍是否存在
- 归还书籍数量是否合法
  - 还的不够，数据不DISABLE，同时提示：您还有*本书尚未归还
  - 还的超了，非法提示
  - 正常还书，count相等，disable数据
- 只要还书成功(正常/少还)，就完成book表的数据数量的增加

## 遗留问题(已修复)

- 还书时候，ENABLE字段没更新
- 最后的提示语，么有提示我还有几本书没还
- NPE异常临时处理，以后怎么规避
