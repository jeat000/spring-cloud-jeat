package com.example.shardingjdbcdemo.normalmapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.shardingjdbcdemo.model.Goods;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface GoodsMapperNormal extends BaseMapper<Goods> {

    List<Map<String, Object>> selectAll();
}
