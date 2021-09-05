package com.kaogu.Controller;

import com.kaogu.Bean.Polygon;
import com.kaogu.Mapper.PolygonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Controller
public class PolygonController {

    @Autowired
    PolygonMapper polygonMapper;

    @GetMapping("/polygon/{id}")
    public String getPolygon(Model model, @PathVariable("id") Integer id){
        Polygon polygon = polygonMapper.getPLYById(id);
        model.addAttribute("polygon", polygon);
        return "new_ply";
    }

    @GetMapping("/model")
    public String model(Model model) {
        List<Polygon> list = polygonMapper.getPLYs();
        model.addAttribute("polygons", list);
        return "Models";
    }

    @GetMapping("/polygons")
    public String getPLYs(Model model) {
        List<Polygon> list = polygonMapper.getPLYs();
        model.addAttribute("polygons", list);
        return "ply_list";
    }

    @GetMapping("/success")
    public String success() {
        return "success";
    }

    @PostMapping("/upload")
    public String Upload_PLY(@RequestPart("ply_files") MultipartFile[] ply_files) throws IOException {
        String root_dir = System.getProperty("user.dir");
        String polygon_dir = root_dir + "/src/main/resources/static/database/";
        String[] file_list = new File(polygon_dir).list();
        for (MultipartFile ply_file : ply_files) {
            if (!ply_file.isEmpty()) {
                String Filename = ply_file.getOriginalFilename();
                if (Filename.endsWith(".ply")) {
                    if (Arrays.asList(file_list).contains(Filename)) {
                        System.out.println(Filename + " existed");
                        continue;
                    }else {
                        ply_file.transferTo(new File(polygon_dir + Filename));
                        String ply_name = Filename;
                        String ply_path = "../static/database/" + Filename;
                        System.out.println("ply_name" + ply_name);
                        System.out.println("ply_path" + ply_path);
                        polygonMapper.insertPLY(ply_name, ply_path);
                        System.out.println("inserted");
                        System.out.println(Filename + " saved");
                    }
                }else {
                    continue;
                }
            }
        }
        return "success";
    }

    @GetMapping("/polygonss")
    public String polygons() {
        return "upload_ply_files";
    }
}
