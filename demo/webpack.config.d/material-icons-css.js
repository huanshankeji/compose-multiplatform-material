const mainEntryExtras = ['material-icons/iconfont/material-icons.css',];
if (config.entry.main != null)
    config.entry.main.push(...mainEntryExtras);
else
    config.entry.main = mainEntryExtras;
