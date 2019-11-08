
## Picker (3.4.5+)
- `picker`是在3.4.5版本后增加的一个新功能，即加强版的`switch`
- `picker`和`switch`一样，通过`get`读取当前状态，通过`set`保存状态
- 其它配置项也和`switch`一致
- `picker`需要你自己定义选项(`option`)，就像这样

### 属性

- 公共属性（功能节点共有）

| 属性 | 作用 | 有效值 | 必需 | 示例 |
| - | - | - | :-: | :- |
| desc | 描述 | 文本内容 | 否 | 显示在标题下的小字，可以不设置 |
| desc-sh | 动态设置desc内容的脚本 | `脚本代码` | 否 | `echo '开关说明信息'` |
| confirm | 点击时是否弹出确认框，默认`false` | `true`、`false` | 否 | `false` |
| visible | 自定义脚本使用echo输出1或0，用于决定该action要不要显示 | 脚本代码 | 否 | `echo '1'` |


- 特有属性

| 属性 | 作用 | 有效值 | 必需 | 示例 |
| - | - | - | :-: | :- |
| interruptible | 是否允许中断执行，默认`true` | `true`、`false` | 否 | `false` |
| auto-off | 执行完脚本后是否自动关闭日志界面，默认`false` | `true`、`false` | 否 | `false` |
| reload-page | 执行完脚本后是否刷新页面，默认`false` | `true` `false` | 否 | `true` |
| bg-task | 是否作为后台任务执行，默认`false` | `true` `false` | 否 | `true` |

```xml
<picker>
    <title>单选列表</title>
    <desc>测试单选列表</desc>
    <options>
        <option value="a1">选项1</option>
        <option value="a2">选项1</option>
    </options>
    <get>getprop xxx.xxx.xxx</get>
    <set>setprop xxx.xxx.xxx $state</set>
</picker>
```

- **动态选项**
- picker也允许使用`options-sh`属性来设置输出下拉选项的脚本
- 用法和action的param一样，如：

```xml
<picker options-sh="echo 'a|选项A'; echo 'b|选项B'">
    <title>测试单选界面</title>
    <desc>测试单选界面</desc>
    <get>getprop xxx.xxx.xxx3</get>
    <set>setprop xxx.xxx.xxx3 "$state"</set>
</picker>
```

- **多选模式**
- 在picker节点上增加`multiple="true"`属性来标识允许多选
- 例如：

```xml
<picker options-sh="echo 'a|选项A'; echo 'b|选项B'" value-sh="echo 'a'; echo 'b';">
    <title>测试单选界面</title>
    <get>getprop xxx.xxx.xxx4</get>
    <set>setprop xxx.xxx.xxx4 "$state"</set>
</picker>
```


#

---

> 相关说明

- 由于在xml中写大量的shell代码非常不方便，也不美观，
- 建议参考 [`脚本使用`](./Script.md) 中的说明，
- 将段落较长的脚本代码，写在单独的文件中。