package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.*;

public class TaskMembersViewListModel {

    private ObservableList<TaskMemberViewModel> membersList;
    private ObservableList<TaskMemberViewModel> membersSearchedList;
    private ProjectModel model;
    private ViewState state;

    public TaskMembersViewListModel(ProjectModel model, ViewState state)
    {
        this.model = model;
        this.membersList = FXCollections.observableArrayList();
        this.membersSearchedList = FXCollections.observableArrayList();
        this.state = state;
        update();
    }

    public ObservableList<TaskMemberViewModel> getMembersList() {
        return membersList;
    }

    public ObservableList<TaskMemberViewModel> getMembersSearchedList() {
        return membersSearchedList;
    }

    public void update()
    {
        membersList.clear();
        for(int i = 0; i < model.getTask(model.getRequirementByIndex(model.getProject(state.getSelectedProject()),
                state.getSelectedRequirement()),state.getSelectedTask()).getTaskMembers().size(); i++)
            membersList.add(new TaskMemberViewModel(model.getTask(model.getRequirementByIndex(model.getProject(state.getSelectedProject()),
                    state.getSelectedRequirement()),state.getSelectedTask()).getTaskMembers().get(i)));
    }

    public void searchMembers(String name)
    {
        membersSearchedList.clear();
        for(int i = 0; i < model.getTask(model.getRequirementByIndex(model.getProject(state.getSelectedProject()),
            state.getSelectedRequirement()),state.getSelectedTask()).getTaskMembers().size(); i++)
            if(model.getTask(model.getRequirementByIndex(model.getProject(state.getSelectedProject()),
                    state.getSelectedRequirement()),state.getSelectedTask()).getTaskMembers().get(i).getName().equals(name))
                membersSearchedList.add(new TaskMemberViewModel(model.getTask(model.getRequirementByIndex(model.getProject(state.getSelectedProject()),
                        state.getSelectedRequirement()),state.getSelectedTask()).getTaskMembers().get(i)));
    }

    public void addMember(Member member)
    {
        membersList.add(new TaskMemberViewModel(member));
    }

    public void remove(int index)
    {
        for(int i = 0; i < membersList.size(); i++)
            if(i == index)
            {
                membersList.remove(i);
                break;
            }
    }
}
