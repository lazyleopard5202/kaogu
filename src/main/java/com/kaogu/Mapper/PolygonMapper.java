package com.kaogu.Mapper;

import com.kaogu.Bean.Polygon;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PolygonMapper {

    @Select("select * from ply where polygon_id=#{id}")
    public Polygon getPLYById(Integer id);

    @Select("select * from ply")
    public List<Polygon> getPLYs();

    @Delete("delete from ply where polygon_id=#{id}")
    public int delPLYById(Integer id);

    @Select("select polygon_name from ply")
    public List<String> getPLYNames();

    @Insert("insert into ply(polygon_name, polygon_path) values (#{name}, #{path})")
    public int insertPLY(String name, String path);

}
