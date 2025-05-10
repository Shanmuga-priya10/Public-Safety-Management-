/*package com.safety.service;

import com.safety.model.Incident;
import com.safety.repository.IncidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncidentService {
    @Autowired
    private IncidentRepository incidentRepository;

    public List<Incident> getAllIncidents() {
        return incidentRepository.findAll();
    }
}*/
package com.safety.service;

import com.safety.model.Incident;
import com.safety.repository.IncidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncidentService {
    @Autowired
    private IncidentRepository incidentRepository;

    public List<Incident> getAllIncidents() {
        return incidentRepository.findAll();
    }

    public Incident createIncident(Incident incident) {
        if (incident.getType() == null || incident.getType().trim().isEmpty()) {
            throw new RuntimeException("Incident type cannot be empty");
        }
        if (incident.getLocation() == null || incident.getLocation().trim().isEmpty()) {
            throw new RuntimeException("Incident location cannot be empty");
        }
        return incidentRepository.save(incident);
    }

    public Incident updateIncident(Long id, Incident incident) {
        Incident existingIncident = incidentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Incident not found with id: " + id));
        if (incident.getType() != null && !incident.getType().trim().isEmpty()) {
            existingIncident.setType(incident.getType());
        }
        if (incident.getLocation() != null && !incident.getLocation().trim().isEmpty()) {
            existingIncident.setLocation(incident.getLocation());
        }
        if (incident.getSeverity() != null) {
            existingIncident.setSeverity(incident.getSeverity());
        }
        if (incident.getStatus() != null) {
            existingIncident.setStatus(incident.getStatus());
        }
        if (incident.getDateTime() != null) {
            existingIncident.setDateTime(incident.getDateTime());
        }
        return incidentRepository.save(existingIncident);
    }

    public void deleteIncident(Long id) {
        if (!incidentRepository.existsById(id)) {
            throw new RuntimeException("Incident not found with id: " + id);
        }
        incidentRepository.deleteById(id);
    }
}