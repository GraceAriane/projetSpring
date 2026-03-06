package com.projet.backend.dto;



public class UserRequest {

    private String name;
    private String email;
    private String password;

    // Constructeur vide (OBLIGATOIRE)
    public UserRequest() {
    }

    /** 
     * @return String
     */
    // Getters
    public String getName() {
        return name;
    }

    /** 
     * @return String
     */
    public String getEmail() {
        return email;
    }

    /** 
     * @return String
     */
    public String getPassword() {
        return password;
    }

    /** 
     * @param name
     */
    // Setters
    public void setName(String name) {
        this.name = name;
    }

    /** 
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /** 
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }
}