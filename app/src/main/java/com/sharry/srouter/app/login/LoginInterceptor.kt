package com.sharry.srouter.app.login

import android.app.Activity.RESULT_OK
import com.sharry.srouter.annotation.RouteInterceptor
import com.sharry.srouter.module.base.ResponseObservable
import com.sharry.srouter.module.base.ModuleConstants
import com.sharry.srouter.support.facade.SRouter
import com.sharry.srouter.support.interceptors.IInterceptor
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * @author Sharry [Contact me.](SharryChooCHN@Gmail.com)
 * @version 1.0
 * @since 2019/2/19 20:15
 */
@RouteInterceptor(
        value = ModuleConstants.App.LOGIN_INTERCEPTOR,
        priority = 10
)
class LoginInterceptor : IInterceptor {

    override fun intercept(chain: IInterceptor.Chain) {
        val chainContext = chain.chainContext()
        // 若没有登录, 则先跳转到登录页面
        if (!ModuleConstants.App.isLogin) {
            val disposable = SRouter.request(ModuleConstants.App.NAME, ModuleConstants.App.LOGIN_ACTIVITY)
                    // 构建 Activity 相关配置
                    .setRequestCode(100)
                    .addInterceptorURI(ModuleConstants.Personal.PERMISSION_INTERCEPTOR)
                    .newCall(chainContext.baseContext)
                    // 将 ICall 转为 ResponseObservable
                    .adaptTo(ResponseObservable::class.java)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe {
                        if (it.activityResult.resultCode == RESULT_OK) {
                            SRouter.navigation(chainContext.baseContext, chainContext.request)
                        }
                    }
            // 跳转到登录页面
            return
        }
        // 若已经登录, 则正常分发
        chain.dispatch()
    }

}
