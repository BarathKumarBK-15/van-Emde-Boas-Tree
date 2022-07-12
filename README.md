# van-Emde-Boas-Tree
Implementation of the van Emde Boas Tree, used in representing disjoint sets.

## Operation
### Insert 
- consists of 3 cases, value to insert is val
- Case 1 (val<min), Insert current node’s min in child cluster,  make current node’s min as val
- Case 2 (val>max), make current node max as val, insert max in child cluster
- Case 3 (val<max and  val>min), insert val in child cluster
- Insert the cluster num into the summary node
  
### Delete  
- consists of 3 cases, value to insert is val
- Case 1 (val == min), make successor(val) as min in current node, in child node delete successor(val) 
- Case 2 (val == max), make predecessor(val) as min in current node, in child node delete predecessor(val) 
- Case 3 (val<max and  val>min), delete val in child cluster
- Update summary node if the cluster is empty

### Min
- return min attribute from current node

### Max
- return max attribute from current node

### Search
- search val in the tree
- Case 1 (val < min or val > max), return false, element not present in tree
- Case 2 (val == min or val == max), return true
- Case 3 (val > min and val < max), search val in child cluster

### Predecessor
- find predecessor of val, without checking if val is present in the tree 
- Case 1 (val =< min), no predecessor, return -1
- Case 2(val > max), return max as predecessor
- Case 3(val > min and val <= max), check for predecessor in same node if no predecessor then check max of left sibling, if max  is -1 then check next left sibling and so on

### Successor 
- find successor of val without checking if val is present in the tree
- Case 1 (val < min), return min as the successor
- Case 2(val >= max), no successor return -1
- Case 3(val > min and val <= max), check for successor in same node if no successor then check min of right sibling, if min is -1 then check next right sibling and so on
