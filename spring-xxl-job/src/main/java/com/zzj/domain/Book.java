package com.zzj.domain;

import java.math.BigDecimal;
import java.util.Date;

public class Book {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column book.id
     *
     * @mbggenerated Mon May 13 09:42:43 CST 2019
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column book.book_name
     *
     * @mbggenerated Mon May 13 09:42:43 CST 2019
     */
    private String bookName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column book.price
     *
     * @mbggenerated Mon May 13 09:42:43 CST 2019
     */
    private BigDecimal price;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column book.author
     *
     * @mbggenerated Mon May 13 09:42:43 CST 2019
     */
    private String author;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column book.create_time
     *
     * @mbggenerated Mon May 13 09:42:43 CST 2019
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column book.last_modify_time
     *
     * @mbggenerated Mon May 13 09:42:43 CST 2019
     */
    private Date lastModifyTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column book.id
     *
     * @return the value of book.id
     *
     * @mbggenerated Mon May 13 09:42:43 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column book.id
     *
     * @param id the value for book.id
     *
     * @mbggenerated Mon May 13 09:42:43 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column book.book_name
     *
     * @return the value of book.book_name
     *
     * @mbggenerated Mon May 13 09:42:43 CST 2019
     */
    public String getBookName() {
        return bookName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column book.book_name
     *
     * @param bookName the value for book.book_name
     *
     * @mbggenerated Mon May 13 09:42:43 CST 2019
     */
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column book.price
     *
     * @return the value of book.price
     *
     * @mbggenerated Mon May 13 09:42:43 CST 2019
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column book.price
     *
     * @param price the value for book.price
     *
     * @mbggenerated Mon May 13 09:42:43 CST 2019
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column book.author
     *
     * @return the value of book.author
     *
     * @mbggenerated Mon May 13 09:42:43 CST 2019
     */
    public String getAuthor() {
        return author;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column book.author
     *
     * @param author the value for book.author
     *
     * @mbggenerated Mon May 13 09:42:43 CST 2019
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column book.create_time
     *
     * @return the value of book.create_time
     *
     * @mbggenerated Mon May 13 09:42:43 CST 2019
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column book.create_time
     *
     * @param createTime the value for book.create_time
     *
     * @mbggenerated Mon May 13 09:42:43 CST 2019
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column book.last_modify_time
     *
     * @return the value of book.last_modify_time
     *
     * @mbggenerated Mon May 13 09:42:43 CST 2019
     */
    public Date getLastModifyTime() {
        return lastModifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column book.last_modify_time
     *
     * @param lastModifyTime the value for book.last_modify_time
     *
     * @mbggenerated Mon May 13 09:42:43 CST 2019
     */
    public void setLastModifyTime(Date lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }
}