package com.hotwax.order.controller;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotwax.order.exception.ServiceException;
import com.hotwax.order.model.ApiResponse;
import com.hotwax.order.model.Party;
import com.hotwax.order.model.ServiceResponse;
import com.hotwax.order.services.PartyService;

import lombok.Data;


@RestController
@RequestMapping("/api/parties")
public class PartyController {
	@Autowired
    private PartyService partyService;

    @GetMapping
    public ResponseEntity<ApiResponse> getAllParties() throws ServiceException {
    	LocalDateTime startApiDateTime = LocalDateTime.now();
        ServiceResponse<List<Party>> serviceResponse = partyService.getAllParties();
        return prepareResponse(serviceResponse,startApiDateTime);
    }

    

	@GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getPartyById(@PathVariable String id) throws ServiceException {
    	LocalDateTime startApiDateTime = LocalDateTime.now();
        ServiceResponse<Party> serviceResponse = partyService.getPartyById(id);
        return prepareResponse(serviceResponse,startApiDateTime);
    }

    @PostMapping
    public ResponseEntity<ApiResponse> createParty(@RequestBody Party party) throws ServiceException {
    	LocalDateTime startApiDateTime = LocalDateTime.now();
        ServiceResponse<Party> serviceResponse = partyService.saveParty(party);
        return prepareResponse(serviceResponse,startApiDateTime);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> updateParty(@PathVariable String id, @RequestBody Party  party) throws ServiceException {
    	LocalDateTime startApiDateTime = LocalDateTime.now();
        ServiceResponse<Party> serviceResponse = partyService.updatePartyById(id, party);
        return prepareResponse(serviceResponse,startApiDateTime);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteParty(@PathVariable String id) throws ServiceException {
    	LocalDateTime startApiDateTime = LocalDateTime.now();
        ServiceResponse<Party> serviceResponse = partyService.deleteParty(id);
        return prepareResponse(serviceResponse,startApiDateTime);
    }
    
    private ResponseEntity<ApiResponse> prepareResponse(ServiceResponse<?> serviceResponse, LocalDateTime startApiDateTime) {
		ApiResponse apiResponse = new ApiResponse();
		apiResponse.setStartDateTime(startApiDateTime);
		apiResponse.setBody(serviceResponse.getBody());
		apiResponse.setMessage(serviceResponse.getMessage());
		apiResponse.setEndDateTime(LocalDateTime.now());
		return ResponseEntity.status(HttpStatusCode.valueOf(serviceResponse.getCode())).body(apiResponse);
	}
}
