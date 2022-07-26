package com.sparta.actorsapi.actorsapi.services;

import com.sparta.actorsapi.actorsapi.dataobjects.Actor;
import com.sparta.actorsapi.actorsapi.dataobjects.Customer;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class SakilaDAO {

    private DataSource dataSource;

    public SakilaDAO(DataSource dataSource) {
        this.dataSource=dataSource;
    }
    public Actor getActor(int id) throws Exception {
        try(Connection conn = dataSource.getConnection()){
            try(PreparedStatement ps = conn.prepareStatement("SELECT  * FROM Actor WHERE actor_Id = ?")){
                ps.setInt(1, id);
                try(ResultSet rs = ps.executeQuery()){
                    if(rs.next())
                        return new Actor(rs.getInt("actor_id"), rs.getString("first_name"),
                            rs.getString("last_name"), rs.getDate("last_update"));
                    else{
                        throw new Exception("Exception thrown when getting actor");
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Actor getActor(String fname, String lname) throws Exception {
        try(Connection conn = dataSource.getConnection()){
            try(PreparedStatement ps = conn.prepareStatement("SELECT  * FROM Actor WHERE first_name = ? AND last_name=?")){
                try(ResultSet rs = ps.executeQuery()){
                    if(rs.next())
                        return new Actor(rs.getInt("actor_id"), rs.getString("first_name"),
                                rs.getString("last_name"), rs.getDate("last_update"));
                    else{
                        throw new Exception("Exception thrown when getting actor");
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Actor> getAllActors() throws Exception {
        try(Connection conn = dataSource.getConnection()){
            try(PreparedStatement ps = conn.prepareStatement("SELECT  * FROM Actor")){
                try(ResultSet rs = ps.executeQuery()){
                    List<Actor> actorList = new ArrayList<>();
                    while (rs.next()){
                        actorList.add(new Actor(rs.getInt("actor_id"), rs.getString("first_name"),
                                rs.getString("last_name"), rs.getDate("last_update")));
                    }
                    return actorList;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Customer getCustomer(int id) throws Exception {
        try (Connection conn = dataSource.getConnection()) {
            try (PreparedStatement ps = conn.prepareStatement("SELECT  * FROM customer WHERE customer_id = ?")) {
                ps.setInt(1, id);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next())
                        return new Customer(rs.getInt("customer_id"), rs.getString("first_name"),
                                rs.getString("last_name"), rs.getString("email"));
                    else {
                        throw new Exception("Exception thrown when getting actor");
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Customer> getAllCustomers() throws Exception {
        try (Connection conn = dataSource.getConnection()) {
            try (PreparedStatement ps = conn.prepareStatement("SELECT  * FROM customer")) {
                try (ResultSet rs = ps.executeQuery()) {
                    List<Customer> actorList = new ArrayList<>();
                    while (rs.next()) {
                        actorList.add(new Customer(rs.getInt("customer_id"), rs.getString("first_name"),
                                rs.getString("last_name"), rs.getString("email")));
                    }
                    return actorList;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void addActor(Actor newActor) {
        System.out.println(newActor);
        try(Connection conn = dataSource.getConnection()){
            try(PreparedStatement ps = conn.prepareStatement("INSERT  INTO ACTOR (actor_id, first_name, last_name) " +
                    "values(?, ?, ?)")){
                ps.setInt(1, newActor.getActorId());
                ps.setString(2, newActor.getFirstName());
                ps.setString(3, newActor.getLastName());
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
