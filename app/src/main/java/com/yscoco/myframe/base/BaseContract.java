/**
 * Copyright 2016 JustWayward Team
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.yscoco.myframe.base;

import com.yscoco.myframe.base.mvp.BaseModel;
import com.yscoco.myframe.dto.BaseDTO;
import com.yscoco.myframe.dto.BaseDataDTO;

/**
 * @author yuyh.
 * @date 16/8/6.
 */
public interface BaseContract {

    interface BasePresenter<T> {

        void attachView(T view);

        void detachView();
    }

    interface BaseView {

        /**
         * 显示dialog
         */
        void showLoading();
        /**
         * 隐藏 dialog
         */

        void hideLoading();
        /**
         * 显示错误信息
         *
         * @param msg
         */
        void showError(String msg);
        /**
         * 错误码
         */
        void onErrorCode(BaseDTO<BaseDataDTO> model);
    }
}
