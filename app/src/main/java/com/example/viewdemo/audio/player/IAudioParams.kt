package com.example.viewdemo.audio.player

/**
 * 音频数据包，定义了音频的编码参数，并提供了音频数据流。一个音频包播放一次，可通过[setRepeatCount]设置重复的次数
 */
interface IAudioPacket {
    /**
     * 获取音频采样率
     */
    fun getSampleRate(): Int

    /**
     * 获取音频声道
     */
    fun getChannel(): Int

    /**
     * 获取音频编码格式
     */
    fun getEncodingFormat(): Int

    /**
     * 读取音频数据流
     */
    fun read(buffer: ByteArray, offset: Int = 0, length: Int = buffer.size): Int

    /**
     * 设置重复的次数
     */
    fun setRepeatCount(count: Int)

}