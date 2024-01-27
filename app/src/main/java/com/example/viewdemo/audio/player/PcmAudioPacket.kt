package com.example.viewdemo.audio.player

import java.io.File
import java.io.InputStream

/**
 * PCM数据包，用于播放PCM数据
 */
class PcmAudioPacket(val file: File) : IAudioPacket {
    // 音频采样率
    private var mSampleRate: Int = 0

    // 音频通道
    private var mChannel: Int = 0

    // 音频编码格式
    private var mEncodingFormat: Int = 0

    // 音频重复播放的次数
    private var mRepeatCount: Int = 0

    // 音频输入流
    private var mInputStream: InputStream? = null

    /**
     * 设置采样率
     */
    fun setSampleRate(sampleRate: Int) = this.apply {
        this.mSampleRate = sampleRate
    }

    /**
     * 设置音频通道
     */
    fun setChannel(channel: Int) {
        this.mChannel = channel
    }

    /**
     * 设置编码格式
     */
    fun setEncodingFormat(encodingFormat: Int) {
        this.mEncodingFormat = encodingFormat
    }

    override fun getSampleRate() = mSampleRate

    override fun getChannel() = mChannel

    override fun getEncodingFormat() = mEncodingFormat

    override fun read(buffer: ByteArray, offset: Int, length: Int): Int {
        if (mInputStream == null) {
            mInputStream = file.inputStream().apply {
                mark(available())
            }
        }
        return with(mInputStream!!) {
            val len = read(buffer, offset, length)
            if (len == -1) {
                close()
            }
            len
        }
    }

    override fun setRepeatCount(count: Int) {
        mRepeatCount = count
    }


}