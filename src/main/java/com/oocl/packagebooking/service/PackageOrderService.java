package com.oocl.packagebooking.service;

import com.oocl.packagebooking.entity.PackageOrder;
import com.oocl.packagebooking.repository.PackageOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class PackageOrderService {
    @Autowired
    private PackageOrderRepository packageOrderRepository;
    public List<PackageOrder> getAllPackageItems() {
        List<PackageOrder> packageOrders =  packageOrderRepository.findAll();
        return packageOrders;

    }

    public void addParkingLot(PackageOrder packageOrder) {
        packageOrder.setBookTime(new Date());
        packageOrderRepository.save(packageOrder);
    }

    public PackageOrder updateAPackageOrder(String id, PackageOrder order) {
        return null;
    }

    public void deleteAPackageOrder(String id) {
        packageOrderRepository.deleteById(id);
    }

    public PackageOrder getAPackageItem(String id) {
        PackageOrder packageOrder = packageOrderRepository.findById(id).get();
        packageOrder.setBookTime(new Date());
        packageOrderRepository.save(packageOrder);
        return packageOrder;
    }
}
