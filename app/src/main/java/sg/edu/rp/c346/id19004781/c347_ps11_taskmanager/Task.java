package sg.edu.rp.c346.id19004781.c347_ps11_taskmanager;

import java.io.Serializable;

class Task implements Serializable {
    private String name;
    private String description;
    private String remainderTimeSecond;

    public Task(String name, String description, String remainderTimeSecond) {
        this.name = name;
        this.description = description;
        this.remainderTimeSecond = remainderTimeSecond;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRemainderTimeSecond() {
        return remainderTimeSecond;
    }

    public void setRemainderTimeSecond(String remainderTimeSecond) {
        this.remainderTimeSecond = remainderTimeSecond;
    }
}