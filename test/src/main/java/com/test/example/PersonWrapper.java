package com.test.example;

import java.util.List;

public class PersonWrapper {
	private List<PersonForList> persons;

    /**
     * @return the persons
     */
    public List<PersonForList> getPersons() {
        return persons;
    }

    /**
     * @param persons the persons to set
     */
    public void setPersons(List<PersonForList> persons) {
        this.persons = persons;
    }
}
