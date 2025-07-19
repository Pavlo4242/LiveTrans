package com.livegemini.data;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\u0002\u0010\fJ\u0011\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\bH\u00c6\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\bH\u00c6\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u000bH\u00c6\u0003\u00a2\u0006\u0002\u0010\u0015JP\u0010\u001c\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bH\u00c6\u0001\u00a2\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u000b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010 \u001a\u00020!H\u00d6\u0001J\t\u0010\"\u001a\u00020#H\u00d6\u0001R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006$"}, d2 = {"Lcom/livegemini/data/ServerContent;", "", "parts", "", "Lcom/livegemini/data/Part;", "modelTurn", "Lcom/livegemini/data/ModelTurn;", "inputTranscription", "Lcom/livegemini/data/Transcription;", "outputTranscription", "turnComplete", "", "(Ljava/util/List;Lcom/livegemini/data/ModelTurn;Lcom/livegemini/data/Transcription;Lcom/livegemini/data/Transcription;Ljava/lang/Boolean;)V", "getInputTranscription", "()Lcom/livegemini/data/Transcription;", "getModelTurn", "()Lcom/livegemini/data/ModelTurn;", "getOutputTranscription", "getParts", "()Ljava/util/List;", "getTurnComplete", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/util/List;Lcom/livegemini/data/ModelTurn;Lcom/livegemini/data/Transcription;Lcom/livegemini/data/Transcription;Ljava/lang/Boolean;)Lcom/livegemini/data/ServerContent;", "equals", "other", "hashCode", "", "toString", "", "livegeminiapi_debug"})
public final class ServerContent {
    @com.google.gson.annotations.SerializedName(value = "parts")
    @org.jetbrains.annotations.Nullable()
    private final java.util.List<com.livegemini.data.Part> parts = null;
    @com.google.gson.annotations.SerializedName(value = "modelTurn")
    @org.jetbrains.annotations.Nullable()
    private final com.livegemini.data.ModelTurn modelTurn = null;
    @com.google.gson.annotations.SerializedName(value = "inputTranscription")
    @org.jetbrains.annotations.Nullable()
    private final com.livegemini.data.Transcription inputTranscription = null;
    @com.google.gson.annotations.SerializedName(value = "outputTranscription")
    @org.jetbrains.annotations.Nullable()
    private final com.livegemini.data.Transcription outputTranscription = null;
    @com.google.gson.annotations.SerializedName(value = "turnComplete")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Boolean turnComplete = null;
    
    public ServerContent(@org.jetbrains.annotations.Nullable()
    java.util.List<com.livegemini.data.Part> parts, @org.jetbrains.annotations.Nullable()
    com.livegemini.data.ModelTurn modelTurn, @org.jetbrains.annotations.Nullable()
    com.livegemini.data.Transcription inputTranscription, @org.jetbrains.annotations.Nullable()
    com.livegemini.data.Transcription outputTranscription, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean turnComplete) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.livegemini.data.Part> getParts() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.livegemini.data.ModelTurn getModelTurn() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.livegemini.data.Transcription getInputTranscription() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.livegemini.data.Transcription getOutputTranscription() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean getTurnComplete() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.livegemini.data.Part> component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.livegemini.data.ModelTurn component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.livegemini.data.Transcription component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.livegemini.data.Transcription component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.livegemini.data.ServerContent copy(@org.jetbrains.annotations.Nullable()
    java.util.List<com.livegemini.data.Part> parts, @org.jetbrains.annotations.Nullable()
    com.livegemini.data.ModelTurn modelTurn, @org.jetbrains.annotations.Nullable()
    com.livegemini.data.Transcription inputTranscription, @org.jetbrains.annotations.Nullable()
    com.livegemini.data.Transcription outputTranscription, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean turnComplete) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
}