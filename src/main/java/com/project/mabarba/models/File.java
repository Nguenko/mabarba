package com.project.mabarba.models;

import javax.persistence.*;

@Entity
public class File {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable=false)
    private long id;
    private String uid;
    private String mimeType;
    private String type; // type de fichier (IMAGE, AUDIO, VIDEO, ou DOCUMENT générique)
    private String extention;
    private double size;
    //private EnumFileFormat format; // Format de stockage d'une image (BINAIRE ou BASE64)
    private String content; // dans le cas où le format base64 est utilisé
    private String description;
    //private EnumStorageAlgorithm storageAlgorithm;
    //private EnumFileType enumFileType;
    private String userId;
    private String documentId;

    public File() {

    }

    public File(String uid, String mimeType) {
        this.uid = uid;
        this.mimeType = mimeType;
    }


    public File(String uid, String mimeType, String extention, double size, String description) {
        this.uid = uid;
        this.mimeType = mimeType;
        this.extention = extention;
        this.size = size;
        this.description = description;

    }

    public File(String uid, String mimeType, String extention, double size, String description,
            String userId) {
        this.uid = uid;
        this.mimeType = mimeType;
        this.extention = extention;
        this.size = size;
        this.description = description;
        this.userId = userId;
    }



    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getExtention() {
        return extention;
    }

    public void setExtention(String extention) {
        this.extention = extention;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }



    @Override
    public String toString() {
        return "File{" +
                "id='" + id + '\'' +
                ", uid='" + uid + '\'' +
                ", mimeType='" + mimeType + '\'' +
                ", type='" + type + '\'' +
                ", extention='" + extention + '\'' +
                ", size=" + size +
                ", content='" + content + '\'' +
                ", description='" + description + '\'' +
                ", userId='" + userId + '\'' +
                ", documentId='" + documentId + '\'' +
                 '}';
    }


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "coiffeurId", insertable=false, updatable=false)
    Coiffeur coiffeur;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "coiffureId", insertable=false, updatable=false)
    Coiffure coiffure;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "salonId", insertable=false, updatable=false)
    Salon salon;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id", insertable=false, updatable=false)
    User user;




}
