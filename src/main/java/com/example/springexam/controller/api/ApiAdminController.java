package com.example.springexam.controller.api;

import com.example.springexam.entity.EmpEntity;
import com.example.springexam.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ApiAdminController {

    @Autowired
    EmpService empService;

    //Lay danh sach
    @GetMapping("/emp")
    public ResponseEntity<List<EmpEntity>> getAllEmp(@ModelAttribute EmpEntity empEntity){
        List<EmpEntity> emp = empService.getAllEmp();
        if (emp != null){
            return new ResponseEntity<>(emp, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //lay 1 danh sach
    @GetMapping("/emp/{id}")
    public ResponseEntity<Optional<EmpEntity>> getOneEmp(@PathVariable("id") Integer id ){
        Optional<EmpEntity> emp = empService.findById(id);
        if (emp.isPresent()){
            return new ResponseEntity<>(emp, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //Them 1 emp
    @PostMapping("/emp")
    public ResponseEntity<EmpEntity> addEmp(@RequestBody EmpEntity empEntity){
        try {
            empService.save(empEntity);
            return new ResponseEntity<>(empEntity, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Sua danh sach
    @PutMapping("/emp/{id}")
    public ResponseEntity<Optional<EmpEntity>> editEmp(@PathVariable("id") Integer id,
                                                           @RequestBody EmpEntity empEntity)
    {
        Optional<EmpEntity> update =empService.findById(id);
        if (update.isPresent()){
            EmpEntity emp = update.get();
            emp.setName(empEntity.getName());
            emp.setWage(empEntity.getWage());


            empService.save(emp);
            return new ResponseEntity<>(update, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    //
    //Xoa danh sach
    @DeleteMapping("/emp/{id}")
    public ResponseEntity<Optional<EmpEntity>> deleteEmp(@PathVariable("id") Integer id){
        Optional<EmpEntity> emp = empService.findById(id);
        if (emp.isPresent()){
            empService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
