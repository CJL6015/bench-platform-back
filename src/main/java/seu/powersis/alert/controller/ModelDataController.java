package seu.powersis.alert.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import seu.powersis.alert.common.model.Result;
import seu.powersis.alert.service.ModelDataService;
import seu.powersis.alert.vo.ModelDataVO;

import javax.validation.constraints.NotBlank;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author chenjiale
 * @version 1.0
 * @date 2023-09-05 22:08
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/model/data")
public class ModelDataController {
    private final ModelDataService modelDataService;

    @GetMapping("/{id}")
    public Result<ModelDataVO> getModelData(@PathVariable Integer id, String type, @NotBlank String index) {
        List<Integer> indexList = Arrays.stream(index.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        ModelDataVO modelData = modelDataService.getModelData(id, type, indexList);
        return Result.success(modelData);
    }
}
