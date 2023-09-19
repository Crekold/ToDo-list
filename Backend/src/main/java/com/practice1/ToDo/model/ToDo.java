package com.practice1.ToDo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "tasks") // Nombre de la tabla en la base de datos
public class ToDo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id") // Nombre de la columna en la base de datos
    private Long taskId;

    private String name_task;
    private LocalDate dueDate;
    private String status;

    @Column(name = "etiquetas_id_e") // Nombre de la columna en la base de datos
    private int etiquetas_id_e;

    // Constructor vacío requerido por JPA
    public ToDo() {
    }

    // Constructor con parámetros
    public ToDo(Long taskId, String name_task, LocalDate dueDate, String status, int etiquetas_id_e) {
        this.taskId = taskId;
        this.name_task = name_task;
        this.dueDate = dueDate;
        this.status = status;
        this.etiquetas_id_e = etiquetas_id_e;
    }

    // Getters y setters
    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public String getName_task() {
        return name_task;
    }

    public void setName_task(String name_task) {
        this.name_task = name_task;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public int getEtiquetas_id_e() {
        return etiquetas_id_e;
    }
    public void setEtiquetas_id_e(int etiquetas_id_e) {
        this.etiquetas_id_e = etiquetas_id_e;
    }
}
