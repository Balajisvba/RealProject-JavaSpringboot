package com.RealProject.RealProject.projections;

import java.time.LocalDate;

public interface ReportProjection {
    String getName();
    LocalDate getDeliveryDate();
    Integer getnumOfCans();
}
