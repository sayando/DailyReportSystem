package com.techacademy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.techacademy.entity.Employee;
import com.techacademy.entity.Report;
import com.techacademy.service.ReportService;

@Controller
@RequestMapping("report")
public class ReportController {
    private final ReportService service;

    public ReportController(ReportService service) {
        this.service = service;
    }

    /** 一覧画面を表示 */
    @GetMapping("/list")
    public String getList(Model model) {
        // 全件検索結果をModelに登録
        model.addAttribute("reportlist", service.getReportList());
        // report/list.htmlに画面遷移
        return "report/list";
    }
    // ----- 詳細画面 -----
    @GetMapping(value = { "/detail", "/detail/{id}/" })
    public String getReport(@PathVariable(name = "id", required = false) Integer id, Model model) {
        // idが指定されていたら検索結果、無ければ空のクラスを設定
        Report report = id != null ? service.getReport(id) : new Report();
        // Modelに登録
        model.addAttribute("report", report);
        // report/detail.htmlに画面遷移
        return "report/detail";
    }
    /** Report登録画面を表示 */
    @GetMapping("/register")
    public String getRegister(@ModelAttribute Report report) {
        // Report登録画面に遷移
        return "report/register";
    }

    /** User登録処理 */
    @PostMapping("/register")
    public String postRegister(Report report) {
        // User登録
        service.saveUser(report);
        // 一覧画面にリダイレクト
        return "redirect:/user/list";
    }
}