package seu.powersis.alert.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import seu.powersis.alert.common.model.Result;
import seu.powersis.alert.dao.entity.TeachTest;
import seu.powersis.alert.dao.service.TeachTestService;

/**
 * @author chenjiale
 * @version 1.0
 * @date 2024-07-12 19:12
 */
@Slf4j
@RestController
@RequiredArgsConstructor
public class TeachController {
    private final TeachTestService teachTestService;

    @GetMapping("/helloworld/{name}")
    public Result<String> helloWorld(@PathVariable String name) {
        return Result.success("你好 " + name);
    }

    @PostMapping("/update")
    public Result<String> update() {
        return Result.success("更新成功");
    }

    @GetMapping("/{id}")
    private Result<TeachTest> getOne(@PathVariable Long id) {
        TeachTest teachTest = teachTestService.getById(id);
        return Result.success(teachTest);
    }
}
