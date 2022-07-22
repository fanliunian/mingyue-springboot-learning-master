package com.csp.mingyue.es.model;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * 古诗词
 *
 * @author Strive
 */
@Data
@ToString
@Document(indexName = "ancient_poetry")
public class AncientPoetry implements Serializable {

  @Id
  @Field(type = FieldType.Text)
  private String id;

  @Field(type = FieldType.Text, analyzer = "ik_max_word")
  private String title;

  @Field(type = FieldType.Text, analyzer = "ik_max_word")
  private String author;

  @Field(type = FieldType.Text, analyzer = "ik_max_word")
  private String content;

  @Field(type = FieldType.Date, format = DateFormat.basic_date_time)
  private Date createTime;
}
