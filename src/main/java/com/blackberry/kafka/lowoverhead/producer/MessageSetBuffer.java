package com.blackberry.kafka.lowoverhead.producer;

import java.nio.ByteBuffer;

public class MessageSetBuffer implements Runnable {
  private int size;
  private byte[] bytes;
  private ByteBuffer buffer;
  private int batchSize = 0;
  private LowOverheadProducer producer;

  public MessageSetBuffer(LowOverheadProducer producer, int size) {
    this.producer = producer;
    this.size = size;
    bytes = new byte[this.size];
    buffer = ByteBuffer.wrap(bytes);
  }

  @Override
  public void run() {
    producer.sendMessage(this);
  }

  public void clear() {
    batchSize = 0;
    buffer.clear();
  }

  public int getSize() {
    return size;
  }

  public void setSize(int size) {
    this.size = size;
  }

  public byte[] getBytes() {
    return bytes;
  }

  public void setBytes(byte[] bytes) {
    this.bytes = bytes;
  }

  public ByteBuffer getBuffer() {
    return buffer;
  }

  public void setBuffer(ByteBuffer buffer) {
    this.buffer = buffer;
  }

  public int getBatchSize() {
    return batchSize;
  }

  public void setBatchSize(int batchSize) {
    this.batchSize = batchSize;
  }

  public LowOverheadProducer getProducer() {
    return producer;
  }

  public void setProducer(LowOverheadProducer producer) {
    this.producer = producer;
  }

  public void incrementBatchSize() {
    batchSize++;
  }

}