// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Serv2_AirQualityCheck.proto

package grpc.service2;

/**
 * <pre>
 * Define the messages for manyAirReadings method
 *(Client Streaming) The client sends a carbon monoxide value and a ground level ozone reading
 * the server compares them to the healthy values that the air sample should have and return a single answer.
 * </pre>
 *
 * Protobuf type {@code PollutionWatch.airDataRequest}
 */
public  final class airDataRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:PollutionWatch.airDataRequest)
    airDataRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use airDataRequest.newBuilder() to construct.
  private airDataRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private airDataRequest() {
    airDataReqMon_ = 0F;
    airDataReqOz_ = 0F;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private airDataRequest(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 13: {

            airDataReqMon_ = input.readFloat();
            break;
          }
          case 21: {

            airDataReqOz_ = input.readFloat();
            break;
          }
          default: {
            if (!parseUnknownFieldProto3(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return grpc.service2.AirQualityCheckImpl.internal_static_PollutionWatch_airDataRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return grpc.service2.AirQualityCheckImpl.internal_static_PollutionWatch_airDataRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            grpc.service2.airDataRequest.class, grpc.service2.airDataRequest.Builder.class);
  }

  public static final int AIRDATAREQMON_FIELD_NUMBER = 1;
  private float airDataReqMon_;
  /**
   * <code>float airDataReqMon = 1;</code>
   */
  public float getAirDataReqMon() {
    return airDataReqMon_;
  }

  public static final int AIRDATAREQOZ_FIELD_NUMBER = 2;
  private float airDataReqOz_;
  /**
   * <code>float airDataReqOz = 2;</code>
   */
  public float getAirDataReqOz() {
    return airDataReqOz_;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (airDataReqMon_ != 0F) {
      output.writeFloat(1, airDataReqMon_);
    }
    if (airDataReqOz_ != 0F) {
      output.writeFloat(2, airDataReqOz_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (airDataReqMon_ != 0F) {
      size += com.google.protobuf.CodedOutputStream
        .computeFloatSize(1, airDataReqMon_);
    }
    if (airDataReqOz_ != 0F) {
      size += com.google.protobuf.CodedOutputStream
        .computeFloatSize(2, airDataReqOz_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof grpc.service2.airDataRequest)) {
      return super.equals(obj);
    }
    grpc.service2.airDataRequest other = (grpc.service2.airDataRequest) obj;

    boolean result = true;
    result = result && (
        java.lang.Float.floatToIntBits(getAirDataReqMon())
        == java.lang.Float.floatToIntBits(
            other.getAirDataReqMon()));
    result = result && (
        java.lang.Float.floatToIntBits(getAirDataReqOz())
        == java.lang.Float.floatToIntBits(
            other.getAirDataReqOz()));
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + AIRDATAREQMON_FIELD_NUMBER;
    hash = (53 * hash) + java.lang.Float.floatToIntBits(
        getAirDataReqMon());
    hash = (37 * hash) + AIRDATAREQOZ_FIELD_NUMBER;
    hash = (53 * hash) + java.lang.Float.floatToIntBits(
        getAirDataReqOz());
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static grpc.service2.airDataRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static grpc.service2.airDataRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static grpc.service2.airDataRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static grpc.service2.airDataRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static grpc.service2.airDataRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static grpc.service2.airDataRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static grpc.service2.airDataRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static grpc.service2.airDataRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static grpc.service2.airDataRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static grpc.service2.airDataRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static grpc.service2.airDataRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static grpc.service2.airDataRequest parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(grpc.service2.airDataRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * <pre>
   * Define the messages for manyAirReadings method
   *(Client Streaming) The client sends a carbon monoxide value and a ground level ozone reading
   * the server compares them to the healthy values that the air sample should have and return a single answer.
   * </pre>
   *
   * Protobuf type {@code PollutionWatch.airDataRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:PollutionWatch.airDataRequest)
      grpc.service2.airDataRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return grpc.service2.AirQualityCheckImpl.internal_static_PollutionWatch_airDataRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return grpc.service2.AirQualityCheckImpl.internal_static_PollutionWatch_airDataRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              grpc.service2.airDataRequest.class, grpc.service2.airDataRequest.Builder.class);
    }

    // Construct using grpc.service2.airDataRequest.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      airDataReqMon_ = 0F;

      airDataReqOz_ = 0F;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return grpc.service2.AirQualityCheckImpl.internal_static_PollutionWatch_airDataRequest_descriptor;
    }

    @java.lang.Override
    public grpc.service2.airDataRequest getDefaultInstanceForType() {
      return grpc.service2.airDataRequest.getDefaultInstance();
    }

    @java.lang.Override
    public grpc.service2.airDataRequest build() {
      grpc.service2.airDataRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public grpc.service2.airDataRequest buildPartial() {
      grpc.service2.airDataRequest result = new grpc.service2.airDataRequest(this);
      result.airDataReqMon_ = airDataReqMon_;
      result.airDataReqOz_ = airDataReqOz_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return (Builder) super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof grpc.service2.airDataRequest) {
        return mergeFrom((grpc.service2.airDataRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(grpc.service2.airDataRequest other) {
      if (other == grpc.service2.airDataRequest.getDefaultInstance()) return this;
      if (other.getAirDataReqMon() != 0F) {
        setAirDataReqMon(other.getAirDataReqMon());
      }
      if (other.getAirDataReqOz() != 0F) {
        setAirDataReqOz(other.getAirDataReqOz());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      grpc.service2.airDataRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (grpc.service2.airDataRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private float airDataReqMon_ ;
    /**
     * <code>float airDataReqMon = 1;</code>
     */
    public float getAirDataReqMon() {
      return airDataReqMon_;
    }
    /**
     * <code>float airDataReqMon = 1;</code>
     */
    public Builder setAirDataReqMon(float value) {
      
      airDataReqMon_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>float airDataReqMon = 1;</code>
     */
    public Builder clearAirDataReqMon() {
      
      airDataReqMon_ = 0F;
      onChanged();
      return this;
    }

    private float airDataReqOz_ ;
    /**
     * <code>float airDataReqOz = 2;</code>
     */
    public float getAirDataReqOz() {
      return airDataReqOz_;
    }
    /**
     * <code>float airDataReqOz = 2;</code>
     */
    public Builder setAirDataReqOz(float value) {
      
      airDataReqOz_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>float airDataReqOz = 2;</code>
     */
    public Builder clearAirDataReqOz() {
      
      airDataReqOz_ = 0F;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:PollutionWatch.airDataRequest)
  }

  // @@protoc_insertion_point(class_scope:PollutionWatch.airDataRequest)
  private static final grpc.service2.airDataRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new grpc.service2.airDataRequest();
  }

  public static grpc.service2.airDataRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<airDataRequest>
      PARSER = new com.google.protobuf.AbstractParser<airDataRequest>() {
    @java.lang.Override
    public airDataRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new airDataRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<airDataRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<airDataRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public grpc.service2.airDataRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
