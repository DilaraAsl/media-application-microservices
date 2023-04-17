package com.tsg.service.impl;

import com.tsg.dto.DeviceDto;
import com.tsg.dto.UserDto;
import com.tsg.entity.Device;
import com.tsg.entity.User;
import com.tsg.exceptions.DeviceNotFoundException;
import com.tsg.exceptions.UserNotFoundException;
import com.tsg.repository.DeviceRepository;
import com.tsg.service.DeviceService;
import com.tsg.service.UserService;
import com.tsg.util.MapperUtil;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeviceServiceImpl implements DeviceService {
    private final DeviceRepository deviceRepository;
    private final MapperUtil mapperUtil;

    public DeviceServiceImpl(DeviceRepository deviceRepository, MapperUtil mapperUtil) {
        this.deviceRepository = deviceRepository;
        this.mapperUtil = mapperUtil;
    }

    @Override
    public List<DeviceDto> findAll() {
        return deviceRepository.findAll().stream().map(device->mapperUtil.convert(device,new DeviceDto()))
                .collect(Collectors.toList());

    }

    @Override
    public DeviceDto save(DeviceDto deviceDto) {
        Device device=new Device();
        device.setId(deviceDto.getId());
         deviceRepository.save(mapperUtil.convert(deviceDto,new Device()));
         return deviceDto;
    }

    @Override
    public DeviceDto findDevice(Long id) {
        return deviceRepository.findById(id).map(device -> mapperUtil.convert(device,new DeviceDto())).orElseThrow();

    }

    @Override
    public DeviceDto delete(Long id) {
        Device device = deviceRepository.findById(id)
                .orElseThrow(() -> new DeviceNotFoundException("User not found"));
      device.setDeleted(true);
        deviceRepository.save(device);
        return findDevice(id);
    }
}
