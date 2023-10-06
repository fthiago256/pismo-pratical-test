package com.pismo.operationaltypes;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OperationalTypeService {

    private final OperationalTypeRepository operationalTypeRepository;

    public OperationalTypeService(OperationalTypeRepository operationalTypeRepository) {
        this.operationalTypeRepository = operationalTypeRepository;
    }

    public Optional<OperationalType> getById(final Long id) {
        return this.operationalTypeRepository.findById(id);
    }
}
