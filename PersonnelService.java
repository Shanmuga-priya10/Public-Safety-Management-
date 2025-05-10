/*package com.safety.service;

import com.safety.model.Personnel;
import com.safety.repository.PersonnelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonnelService {
    @Autowired
    private PersonnelRepository personnelRepository;

    public List<Personnel> getAllPersonnel() {
        return personnelRepository.findAll();
    }
}*/

package com.safety.service;

import com.safety.model.Personnel;
import com.safety.repository.PersonnelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonnelService {
    @Autowired
    private PersonnelRepository personnelRepository;

    public List<Personnel> getAllPersonnel() {
        return personnelRepository.findAll();
    }

    public Personnel createPersonnel(Personnel personnel) {
        if (personnel.getName() == null || personnel.getName().trim().isEmpty()) {
            throw new RuntimeException("Personnel name cannot be empty");
        }
        if (personnel.getRole() == null || personnel.getRole().trim().isEmpty()) {
            throw new RuntimeException("Personnel role cannot be empty");
        }
        return personnelRepository.save(personnel);
    }

    public Personnel updatePersonnel(Long id, Personnel personnel) {
        Personnel existingPersonnel = personnelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Personnel not found with id: " + id));
        if (personnel.getName() != null && !personnel.getName().trim().isEmpty()) {
            existingPersonnel.setName(personnel.getName());
        }
        if (personnel.getRole() != null && !personnel.getRole().trim().isEmpty()) {
            existingPersonnel.setRole(personnel.getRole());
        }
        return personnelRepository.save(existingPersonnel);
    }

    public void deletePersonnel(Long id) {
        if (!personnelRepository.existsById(id)) {
            throw new RuntimeException("Personnel not found with id: " + id);
        }
        personnelRepository.deleteById(id);
    }
}