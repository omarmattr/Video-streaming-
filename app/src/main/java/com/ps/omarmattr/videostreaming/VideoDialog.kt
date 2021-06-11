package com.ps.omarmattr.videostreaming

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.DialogFragment
import cn.jzvd.JZVideoPlayer
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.upstream.DataSource
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.ps.omarmattr.videostreaming.databinding.VideoDialogBinding

class VideoDialog :DialogFragment() {
    private val mBinding by lazy {
        VideoDialogBinding.inflate(layoutInflater)
    }

    private var simpleExoplayer: SimpleExoPlayer? = null
    private val dataSourceFactory: DataSource.Factory by lazy {
        DefaultDataSourceFactory(requireContext(), "exoplayer-sample")
    }
    var url: String? = null

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
            url = it[0]
            uriVideo(it[0],it[1])
        }
    }
    private fun uriVideo(uri: String, image: String) {
//        val video = mBinding.video
//        try {
//            video.setUp(
//                uri,
//                JZVideoPlayerStandard.SCREEN_WINDOW_NORMAL,
//                ""
//            )
//            Glide.with(this).load(image)
//                .into(video.thumbImageView)
//
//        } catch (e: Exception) {
//
//        }
        simpleExoplayer = SimpleExoPlayer.Builder(requireContext()).build()
        preparePlayer(uri)
        mBinding.video.player = simpleExoplayer
        simpleExoplayer?.playWhenReady = true
    }
    override fun onResume() {
        super.onResume()
        if (url != null)
            uriVideo(url!!,"")
    }

    override fun onStop() {
        super.onStop()
        simpleExoplayer?.release()
    }
    private fun preparePlayer(videoUrl: String) {
        simpleExoplayer?.prepare(ProgressiveMediaSource.Factory(dataSourceFactory)
            .createMediaSource(Uri.parse(videoUrl)))
    }

    override fun onPause() {
        super.onPause()
        JZVideoPlayer.releaseAllVideos()
    }


}