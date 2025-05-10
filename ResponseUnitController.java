/*package com.safety.controller;

import com.safety.model.ResponseUnit;
import com.safety.service.ResponseUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/response-units")
public class ResponseUnitController {
    @Autowired
    private ResponseUnitService responseUnitService;

    @GetMapping
    public List<ResponseUnit> getAllResponseUnits() {
        return responseUnitService.getAllResponseUnits();
    }
}*/
package com.safety.controller;

import com.safety.model.ResponseUnit;
import com.safety.service.ResponseUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/response-units")
public class ResponseUnitController {
    @Autowired
    private ResponseUnitService responseUnitService;

    @GetMapping
    public List<ResponseUnit> getAllResponseUnits() {
        return responseUnitService.getAllResponseUnits();
    }

    @PostMapping
    public ResponseEntity<?> createResponseUnit(@RequestBody ResponseUnit responseUnit) {
        try {
            ResponseUnit createdResponseUnit = responseUnitService.createResponseUnit(responseUnit);
            return ResponseEntity.ok(createdResponseUnit);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateResponseUnit(@PathVariable Long id, @RequestBody ResponseUnit responseUnit) {
        try {
            ResponseUnit updatedResponseUnit = responseUnitService.updateResponseUnit(id, responseUnit);
            return ResponseEntity.ok(updatedResponseUnit);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteResponseUnit(@PathVariable Long id) {
        try {
            responseUnitService.deleteResponseUnit(id);
            return ResponseEntity.ok("Response Unit deleted successfully");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}