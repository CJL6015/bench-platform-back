package seu.powersis.alert.service.impl;

import cn.hutool.http.HttpUtil;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import seu.powersis.alert.common.model.ExaPoint;
import seu.powersis.alert.service.ExaService;
import seu.powersis.alert.vo.PointOptionItemVO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author chenjiale
 * @version 1.0
 * @date 2023-08-20 20:23
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class ExaServiceImpl implements ExaService {
    private static final String EXA_SEARCH_FORMATTER = "ItemName like'%%%s%%' or Descriptor like '%%%s%%'";

    private static final String EXA_SEARCH_KEY = "WhereClause";

    private static final String ID_SPLIT = "|";

    @Value("${exa.get-item-url}")
    private String getItemsUrl;

    @Override
    public List<PointOptionItemVO> getPointOptionList(String search) {
        try {
            String whereClause = String.format(EXA_SEARCH_FORMATTER, search, search);
            Map<String, Object> params = new HashMap<>(4);
            params.put(EXA_SEARCH_KEY, whereClause);
            String body = HttpUtil.get(getItemsUrl, params);
            if (!StringUtils.hasLength(body)) {
                log.error("获取exa异常:{}", search);
                return new ArrayList<>();
            }
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            body = objectMapper.readValue(body, String.class);
            List<ExaPoint> points = objectMapper.readValue(body, new TypeReference<List<ExaPoint>>() {
            });
            return points.stream().map(p -> PointOptionItemVO.builder()
                            .id(p.getDescriptor() + ID_SPLIT +
                                    p.getItemName() + ID_SPLIT +
                                    p.getEngUnits() + ID_SPLIT +
                                    p.getUpperLimit() + ID_SPLIT +
                                    p.getLowerLimit())
                            .name(p.getDescriptor() + "  (" + p.getItemName() + ")")
                            .build())
                    .collect(Collectors.toList());
        } catch (Exception e) {
            log.error("获取exa异常:{}", search, e);
        }
        return new ArrayList<>();
    }
}
