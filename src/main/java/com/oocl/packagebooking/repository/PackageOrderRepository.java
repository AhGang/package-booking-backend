package com.oocl.packagebooking.repository;

import com.oocl.packagebooking.entity.PackageOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PackageOrderRepository extends JpaRepository<PackageOrder,String> {
}
