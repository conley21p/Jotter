package calendar;

public class UploadFile {
    private String attachmentFile; //path to the file?
    private String assignmentName; //Name of the assignment the File is attached to

    public UploadFile(String file, String name){
        attachmentFile = file;
        assignmentName = name;
    }

    public String getAttachmentFile() {
        return attachmentFile;
    }

    public String getAssignmentName() {
        return assignmentName;
    }
}
