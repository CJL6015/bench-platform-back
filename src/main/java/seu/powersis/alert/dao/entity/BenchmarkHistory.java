package seu.powersis.alert.dao.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Date;

/**
 * @author 陈小黑
 * @TableName benchmark_history
 */
@Data
@Slf4j
@TableName(value = "benchmark_history")
public class BenchmarkHistory implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
    /**
     * 唯一编号
     */
    private Integer nno;

    /**
     * 对标模型编号
     */
    private Integer modelId;

    /**
     * 工况编号
     */
    private String bId;

    /**
     *
     */
    private Integer b1Id;

    /**
     *
     */
    private Integer b2Id;

    /**
     *
     */
    private Integer b3Id;

    /**
     *
     */
    private Integer b4Id;

    /**
     *
     */
    private Integer b5Id;

    /**
     *
     */
    private Integer b6Id;

    /**
     *
     */
    private Integer b7Id;

    /**
     *
     */
    private Integer b8Id;

    /**
     *
     */
    private Integer b9Id;

    /**
     *
     */
    private Integer b10Id;

    /**
     * 该工况样本所在起始时间
     */
    private Date starttime;

    /**
     * 该工况样本所在结束时间
     */
    private Date endtime;

    /**
     * 该工况样本数量
     */
    private Integer samplenum;

    /**
     * max/min/avg
     */
    private String type;

    /**
     * 升负荷/降负荷/稳态/大波动
     */
    private String tflag;

    /**
     * 目标参数值
     */
    private Double targetvalue;

    /**
     *
     */
    private Date inserttime;

    /**
     *
     */
    private Double b1;

    /**
     *
     */
    private Double b2;

    /**
     *
     */
    private Double b3;

    /**
     *
     */
    private Double b4;

    /**
     *
     */
    private Double b5;

    /**
     *
     */
    private Double b6;

    /**
     *
     */
    private Double b7;

    /**
     *
     */
    private Double b8;

    /**
     *
     */
    private Double b9;

    /**
     *
     */
    private Double b10;

    /**
     *
     */
    private Double r1;

    /**
     *
     */
    private Double r2;

    /**
     *
     */
    private Double r3;

    /**
     *
     */
    private Double r4;

    /**
     *
     */
    private Double r5;

    /**
     *
     */
    private Double r6;

    /**
     *
     */
    private Double r7;

    /**
     *
     */
    private Double r8;

    /**
     *
     */
    private Double r9;

    /**
     *
     */
    private Double r10;

    /**
     *
     */
    private Double r11;

    /**
     *
     */
    private Double r12;

    /**
     *
     */
    private Double r13;

    /**
     *
     */
    private Double r14;

    /**
     *
     */
    private Double r15;

    /**
     *
     */
    private Double r16;

    /**
     *
     */
    private Double r17;

    /**
     *
     */
    private Double r18;

    /**
     *
     */
    private Double r19;

    /**
     *
     */
    private Double r20;

    /**
     *
     */
    private Double r21;

    /**
     *
     */
    private Double r22;

    /**
     *
     */
    private Double r23;

    /**
     *
     */
    private Double r24;

    /**
     *
     */
    private Double r25;

    /**
     *
     */
    private Double r26;

    /**
     *
     */
    private Double r27;

    /**
     *
     */
    private Double r28;

    /**
     *
     */
    private Double r29;

    /**
     *
     */
    private Double r30;

    /**
     *
     */
    private Double r31;

    /**
     *
     */
    private Double r32;

    /**
     *
     */
    private Double r33;

    /**
     *
     */
    private Double r34;

    /**
     *
     */
    private Double r35;

    /**
     *
     */
    private Double r36;

    /**
     *
     */
    private Double r37;

    /**
     *
     */
    private Double r38;

    /**
     *
     */
    private Double r39;

    /**
     *
     */
    private Double r40;

    /**
     *
     */
    private Double r41;

    /**
     *
     */
    private Double r42;

    /**
     *
     */
    private Double r43;

    /**
     *
     */
    private Double r44;

    /**
     *
     */
    private Double r45;

    /**
     *
     */
    private Double r46;

    /**
     *
     */
    private Double r47;

    /**
     *
     */
    private Double r48;

    /**
     *
     */
    private Double r49;

    /**
     *
     */
    private Double r50;

    public Object getPropertyByName(String propertyName) {
        Object propertyValue = null;
        try {
            Field field = BenchmarkHistory.class.getDeclaredField(propertyName);
            field.setAccessible(true);
            propertyValue = field.get(this);
        } catch (NoSuchFieldException | SecurityException | IllegalAccessException e) {
            log.error("获取属性异常,属性名:{}", propertyName);
        }
        return propertyValue;
    }
}