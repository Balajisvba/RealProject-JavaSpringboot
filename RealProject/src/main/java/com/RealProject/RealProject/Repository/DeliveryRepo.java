package com.RealProject.RealProject.Repository;

import com.RealProject.RealProject.Model.Delivery;
import com.RealProject.RealProject.projections.AllCustomerExcel;
import com.RealProject.RealProject.projections.MonthReportProjection;
import com.RealProject.RealProject.projections.ReportProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DeliveryRepo extends JpaRepository<Delivery,Integer> {

    @Query(value="SELECT c.name, d.delivery_date, d.num_of_cans FROM customer c LEFT JOIN delivery d ON c.id = d.customer_id WHERE c.id = :id;",nativeQuery = true)
    List<ReportProjection>monthReport(Long id);

    @Query(value="SELECT c.name, d.delivery_date, d.num_of_cans FROM customer c LEFT JOIN delivery d ON c.id = d.customer_id WHERE c.name = :name",nativeQuery =true)
    List<ReportProjection>reportByName(String name);

    @Query(value="SELECT c.name,DATE_FORMAT(d.delivery_date, '%Y-%m') AS month,SUM(d.num_of_cans) AS totalCans FROM delivery d LEFT JOIN customer c on customer_id=c.id WHERE c.name = :name GROUP BY DATE_FORMAT(d.delivery_date, '%Y-%m') ORDER BY month ASC;", nativeQuery = true)
    List<MonthReportProjection>excelmonthReport(String name);

    @Query(value="SELECT c.id,c.name,c.address,COALESCE(SUM(d.num_of_cans), 0)  AS total_cans,(COALESCE(SUM(d.num_of_cans), 0)  * c.price_per_can) As Amount\n" +
            "FROM customer c LEFT JOIN delivery d ON c.id = d.customer_id AND MONTH(d.delivery_date) =:month GROUP BY c.id, c.name, c.address ORDER BY c.name;",nativeQuery = true)
    List<AllCustomerExcel>allCustomerExcel(int month);


    @Query(value="SELECT COALESCE(SUM(d.num_of_cans), 0) AS total_cans FROM delivery d WHERE d.customer_id =:customerId  AND MONTH(d.delivery_date) =:billMonth ;",nativeQuery = true)
    int totCans(int billMonth,int customerId);
}
