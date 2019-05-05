package com.sharry.srouter.module.component2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sharry.srouter.annotation.Route
import com.sharry.srouter.annotation.ThreadMode

/**
 * 第二个 Module 中的 Activity.
 *
 * @author Sharry <a href="SharryChooCHN@Gmail.com">Contact me.</a>
 * @version 1.0
 * @since 2018/8/22 20:14
 */
@Route(
        authority = "modulecomponent2",
        path = "PersonalActivity",
        mode = ThreadMode.MAIN,
        interceptorURIs = ["component2/PermissionInterceptor", "app/LoginInterceptor"],
        desc = "个人中心页面"
)
class PersonalActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.component2_activity_personal)
    }

}