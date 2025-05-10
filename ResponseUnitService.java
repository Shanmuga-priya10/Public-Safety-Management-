/*package com.safety.service;

import com.safety.model.ResponseUnit;
import com.safety.repository.ResponseUnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResponseUnitService {
    @Autowired
    private ResponseUnitRepository responseUnitRepository;

    public List<ResponseUnit> getAllResponseUnits() {
        return responseUnitRepository.findAll();
    }
}*/

package com.safety.service;

import com.safety.model.ResponseUnit;
import com.safety.repository.ResponseUnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResponseUnitService {
    @Autowired
    private ResponseUnitRepository responseUnitRepository;

    public List<ResponseUnit> getAllResponseUnits() {
        return responseUnitRepository.findAll();
    }

    public ResponseUnit createResponseUnit(ResponseUnit responseUnit) {
        if (responseUnit.getType() == null || responseUnit.getType().trim().isEmpty()) {
            throw new RuntimeException("Response Unit type cannot be empty");
        }
        if (responseUnit.getStatus() == null || responseUnit.getStatus().trim().isEmpty()) {
            throw new RuntimeException("Response Unit status cannot be empty");
        }
        return responseUnitRepository.save(responseUnit);
    }

    public ResponseUnit updateResponseUnit(Long id, ResponseUnit responseUnit) {
        ResponseUnit existingResponseUnit = responseUnitRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Response Unit not found with id: " + id));
        if (responseUnit.getType() != null && !responseUnit.getType().trim().isEmpty()) {
            existingResponseUnit.setType(responseUnit.getType());
        }
        if (responseUnit.getStatus() != null && !responseUnit.getStatus().trim().isEmpty()) {
            existingResponseUnit.setStatus(responseUnit.getStatus());
        }
        if (responseUnit.getArrivalTime() != null) {
            existingResponseUnit.setArrivalTime(responseUnit.getArrivalTime());
        }
        return responseUnitRepository.save(existingResponseUnit);
    }

    public void deleteResponseUnit(Long id) {
        if (!responseUnitRepository.existsById(id)) {
            throw new RuntimeException("Response Unit not found with id: " + id);
        }
        responseUnitRepository.deleteById(id);
    }
}