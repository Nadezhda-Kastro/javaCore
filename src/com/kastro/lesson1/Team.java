package com.kastro.lesson1;

public class Team {
    private String name;
    private Participant[] participants;

    public Team(String name, Participant[] participants) {
        this.name = name;
        this.participants = participants;
    }

    public Participant[] getParticipants() {
        return participants;
    }

    public void showResult() {
        for (int i = 0; i < participants.length; i++) {
            if(participants[i].isComplete()) {
                System.out.println(participants[i].whoIs() + " прошел дистанцию");
            }
        }
    }


    public void membersTeam() {
        for (int i = 0; i < participants.length; i++) {
            System.out.println(participants[i].whoIs());
        }
    }
}
