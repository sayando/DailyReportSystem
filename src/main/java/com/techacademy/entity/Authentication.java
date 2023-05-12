package com.techacademy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;

@Data //Lombokのアノテーションです。「getter/setter、toString、hashCode、equals」のメソッドを生成します。
@Entity
@Table(name = "Authentication")
public class Authentication {

    /** 権限用の列挙型 */
    public static enum role {
        一般, 管理者
    }
    
    /** 社員番号 */
    @Id //主キーを表すアノテーション
    @Column(length = 20, nullable = false)
    private String code;

    /** パスワード */
    @Column(length = 255, nullable = false)
    private String password;

    /** 権限 */
    @Column(length = 10, nullable = false)
    private String role;

    /** 従業員テーブルのID */
    @OneToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

}
