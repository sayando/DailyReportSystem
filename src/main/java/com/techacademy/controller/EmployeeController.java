package com.techacademy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ModelAttribute; 
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.techacademy.entity.Employee;
import com.techacademy.service.EmployeeService;

@Controller
@RequestMapping("employee2")
public class EmployeeController {
    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    /** 一覧画面を表示 */
    @GetMapping("/list")
    public String getList(Model model) {
        // 全件検索結果をModelに登録
        model.addAttribute("employeelist", service.getEmployeeList());
        // templatesフォルダにあるemployeeフォルダのlist.htmlを参照
        return "employee/list";
    }
    
    // ----- 詳細画面 -----
    @GetMapping(value = { "/detail", "/detail/{id}/" })
    public String getEmployee(@PathVariable(name = "id", required = false) Integer id, Model model) {
        // idが指定されていたら検索結果、無ければ空のクラスを設定
        Employee employee = id != null ? service.getEmployee(id) : new Employee();
        // Modelに登録
        model.addAttribute("employee", employee);
        // employee/detail.htmlに画面遷移
        return "employee/detail";
    }

    // ----- 更新（追加） -----
    @PostMapping("/detail")
    public String postCountry(@RequestParam("id") Integer id, @RequestParam("name") String name,
            @RequestParam("dalete_flag") int delete_flag, Model model) {
        // 更新（追加）
        service.updateEmployee(id, name, delete_flag);

        // 一覧画面にリダイレクト
        return "redirect:/employee/list";
    }

    // ----- 削除画面 -----
    @GetMapping("/delete")
    public String deleteEmployeeForm(Model model) {
        // employee/delete.htmlに画面遷移
        return "employee/delete";
    }

    // ----- 削除 -----
    @PostMapping("/delete")
    public String deleteEmployee(@RequestParam("id") String code, Model model) {
        // 削除
        //service.deleteEmployee(employee);

        // 一覧画面にリダイレクト
        return "redirect:/employee/list";
    }

    /** User登録画面を表示 */
    @GetMapping("/register")
    public String getRegister(@ModelAttribute Employee employee) {
        // Employee登録画面に遷移
        return "employee/register";
    }

    /** Employee登録処理 */
    @PostMapping("/register")
    public String postRegister(Employee employee) {
        // Employee登録
        service.saveEmployee(employee);
        // 一覧画面にリダイレクト
        return "redirect:/employee/list";
    }

    /* Employee更新画面を表示 */
    @GetMapping("/update/{id}/")
    public String getUser(@PathVariable("id")  Integer id, Model model) {
        // Modelに登録
        model.addAttribute("employee", service.getEmployee(id));
        // Employee更新画面に遷移
        return "employee/update";
    }
    
    /* Employee更新画面を表示 
    @GetMapping("/update/")
    public String getUpdate2( Model model) {
        // Modelに登録
        model.addAttribute("employee", service.getEmployee(1));
        // Employee更新画面に遷移
        return "employee/update";
    }　*/
    /* Employee更新処理 */
    @PostMapping("/update/{id}/")
    public String postUpdate(Employee employee) {
        // Employee登録
        service.saveEmployee(employee);
        // 一覧画面にリダイレクト
        return "redirect:/employee/list"; 
    } 
}
