package com.adawolfs.schedule.controls

import com.joanzapata.iconify.Icon
import com.joanzapata.iconify.IconFontDescriptor

/**
 * Created by adawolfs on 6/02/17.
 */
class FontAwesomeModule : IconFontDescriptor {
    override fun ttfFileName(): String {
        return "fonts/fontawesome-webfont.ttf";
    }

    override fun characters(): Array<out Icon> {
        return FontAwesomeIcons.values()
    }
}