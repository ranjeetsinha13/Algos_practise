package android

/*fun findViewById(viewGroup viewGroup, id: Int): View {
    if(viewGroup == null || viewGroup.getChildCount() == 0) return null
    if(viewGroup.getId() == id) return viewGroup
    for(i in viewGroup.indices) {
        var childView =  viewGroup.getChildAt(i)
        if(childView.getId() == id) {
            return childView
        }
        if(viewGroup.get(i) is ViewGroup) {
            return findViewById(viewGroup.get(i))
        }
    }

    return null

} */