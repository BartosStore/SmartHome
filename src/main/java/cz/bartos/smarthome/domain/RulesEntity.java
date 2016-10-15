package cz.bartos.smarthome.domain;

/**
 *
 * @author Mira
 */
public class RulesEntity {

    private String evaluationNodeTitle;
    private String actionChannel;
    private String actionNodeAddress;
    private String evaluationAddDate;
    private String actionAddDate;
    private String date;
    private String evaluationChannel;
    private String evaluationNodeAddress;
    private String id;
    private String evaluationCondition;
    private String evaluationValue;
    private String title;
    private String description;
    private String actionData;
    private String actionNodeTitle;

    public RulesEntity() {
    }

    public String getEvaluationNodeTitle() {
        return evaluationNodeTitle;
    }

    public void setEvaluationNodeTitle(String evaluationNodeTitle) {
        this.evaluationNodeTitle = evaluationNodeTitle;
    }

    public String getActionChannel() {
        return actionChannel;
    }

    public void setActionChannel(String actionChannel) {
        this.actionChannel = actionChannel;
    }

    public String getActionNodeAddress() {
        return actionNodeAddress;
    }

    public void setActionNodeAddress(String actionNodeAddress) {
        this.actionNodeAddress = actionNodeAddress;
    }

    public String getEvaluationAddDate() {
        return evaluationAddDate;
    }

    public void setEvaluationAddDate(String evaluationAddDate) {
        this.evaluationAddDate = evaluationAddDate;
    }

    public String getActionAddDate() {
        return actionAddDate;
    }

    public void setActionAddDate(String actionAddDate) {
        this.actionAddDate = actionAddDate;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEvaluationChannel() {
        return evaluationChannel;
    }

    public void setEvaluationChannel(String evaluationChannel) {
        this.evaluationChannel = evaluationChannel;
    }

    public String getEvaluationNodeAddress() {
        return evaluationNodeAddress;
    }

    public void setEvaluationNodeAddress(String evaluationNodeAddress) {
        this.evaluationNodeAddress = evaluationNodeAddress;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEvaluationCondition() {
        return evaluationCondition;
    }

    public void setEvaluationCondition(String evaluationCondition) {
        this.evaluationCondition = evaluationCondition;
    }

    public String getEvaluationValue() {
        return evaluationValue;
    }

    public void setEvaluationValue(String evaluationValue) {
        this.evaluationValue = evaluationValue;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getActionData() {
        return actionData;
    }

    public void setActionData(String actionData) {
        this.actionData = actionData;
    }

    public String getActionNodeTitle() {
        return actionNodeTitle;
    }

    public void setActionNodeTitle(String actionNodeTitle) {
        this.actionNodeTitle = actionNodeTitle;
    }

    @Override
    public String toString() {
        return "RulesEntity{" + 
                "evaluationNodeTitle=" + evaluationNodeTitle + 
                ", actionChannel=" + actionChannel + 
                ", actionNodeAddress=" + actionNodeAddress + 
                ", evaluationAddDate=" + evaluationAddDate + 
                ", actionAddDate=" + actionAddDate + ", date=" + date + 
                ", evaluationChannel=" + evaluationChannel + 
                ", evaluationNodeAddress=" + evaluationNodeAddress + 
                ", id=" + id + 
                ", evaluationCondition=" + evaluationCondition + 
                ", evaluationValue=" + evaluationValue + 
                ", title=" + title + ", description=" + description + 
                ", actionData=" + actionData + 
                ", actionNodeTitle=" + actionNodeTitle + '}';
    }
}
