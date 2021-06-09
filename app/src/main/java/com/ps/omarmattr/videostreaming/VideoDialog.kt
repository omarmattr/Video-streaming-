package com.ps.omarmattr.videostreaming

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.DialogFragment
import cn.jzvd.JZVideoPlayer
import cn.jzvd.JZVideoPlayerStandard
import com.bumptech.glide.Glide
import com.ps.omarmattr.videostreaming.databinding.VideoDialogBinding

class VideoDialog :DialogFragment() {
    private val mBinding by lazy {
        VideoDialogBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = mBinding.root
    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.MATCH_PARENT
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireArguments().getStringArrayList("url")?.let {
            uriVideo(it[0],it[1])
        }
    }
    private fun uriVideo(uri: String, image: String) {
        val video = mBinding.video
        try {
            video.setUp(
                uri,
                JZVideoPlayerStandard.SCREEN_WINDOW_NORMAL,
                ""
            )
            Glide.with(this).load(image)
                .into(video.thumbImageView)

        } catch (e: Exception) {

        }
    }



    override fun onPause() {
        super.onPause()
        JZVideoPlayer.releaseAllVideos()
    }
}