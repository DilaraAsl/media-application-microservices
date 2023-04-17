package com.tsg.service;

import com.tsg.dto.DeviceDto;
import com.tsg.dto.UserDto;

import java.util.List;

public interface DeviceService {
    public List<DeviceDto> findAll();
    public DeviceDto save(DeviceDto deviceDto);

    public DeviceDto findDevice(Long id);
    public DeviceDto delete(Long id);
}
