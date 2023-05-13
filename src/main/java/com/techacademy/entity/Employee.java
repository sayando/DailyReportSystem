package com.techacademy.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.PreRemove;
//import javax.validation.constraints.Email;
//import javax.validation.constraints.Max;
//import javax.validation.constraints.Min;
//import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.NotNull;
//import org.hibernate.validator.constraints.Length;
import org.springframework.transaction.annotation.Transactional;
import lombok.Data;

@Data
@Entity
@Table(name = "employee")
public class Employee {

    /** 主キー。自動生成 */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @OneToOne(mappedBy="employee")
    private Authentication authentication;

    @Column(length = 20, nullable = false)
    /** 名前。20桁。null不許可 */
    private String name;

    /** 削除フラグ */
    private Boolean delete_flag;

    /** 年齢 */
    private Integer age;

    /** 登録日時 */
    private LocalDateTime created_at;
    
    /** 更新日時 */
    private LocalDateTime updated_at;

}